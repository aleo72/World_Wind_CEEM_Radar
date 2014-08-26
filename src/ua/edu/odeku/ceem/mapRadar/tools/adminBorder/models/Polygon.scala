/*
 * Odessa State environmental University
 * Copyright (C) 2014
 */

package ua.edu.odeku.ceem.mapRadar.tools.adminBorder.models

import ua.edu.odeku.ceem.mapRadar.db.{DB, CeemTableObject}

import scala.slick.driver.H2Driver
import scala.slick.driver.H2Driver.simple._
import scala.slick.jdbc.meta.MTable
import scala.slick.lifted.ProvenShape

/**
 * Модель класу який описує
 * Created by aleo on 17.08.14.
 */
case class Polygon(id: Option[Long], listCoordinates: String, countryBorder: Option[Long], provinceBorder: Option[Long])

class Polygons(tag: Tag) extends Table[Polygon](tag, "POLYGONS"){

  def id = column[Option[Long]]("ID", O.PrimaryKey, O.AutoInc)

  def listCoordinates = column[String]("LIST_COORDINATES", O.NotNull)

  def countryBorder = column[Option[Long]]("country_border", O.Nullable)

  def provinceBorder = column[Option[Long]]("Province_Border", O.Nullable)

  def countryBorderFK = foreignKey("country_Border_fk", countryBorder, CountryBorders.objects)(_.id)

  def provinceBorderFK = foreignKey("province_border_fk", provinceBorder, ProvinceBorders.objects)(_.id)

  def countryBorderJoin = CountryBorders.objects.filter(_.id === countryBorder)

  def provinceBorderJoin = ProvinceBorders.objects.filter(_.id === provinceBorder)

  override def * : ProvenShape[Polygon] = (id, listCoordinates, countryBorder, provinceBorder) <> (Polygon.tupled, Polygon.unapply)
}

object Polygons extends CeemTableObject {

  val objects = TableQuery[Polygons]

  val table = Polygons.objects.baseTableRow

  val tableName = table.tableName

  override def createIfNotExists(existsTables: List[MTable], db: H2Driver.backend.DatabaseDef): Unit = {
    if(!existsTables.exists(_.name.name == tableName)){
      db withSession { implicit session =>
        objects.ddl.create
      }
    }
  }

  def += (polygon: Polygon) = DB.database withSession { implicit session => objects += polygon }

  def ++= (polygons: Iterable[Polygon]) = DB.database withSession { implicit session => objects ++= polygons }

  def <= (polygon: Polygon) = {
    DB.database withSession { implicit session =>
      val v = objects returning objects.map(_.id) += polygon
      Polygon(v, polygon.listCoordinates, polygon.countryBorder, polygon.provinceBorder)
    }
  }

}
