/*
 * Odessa State environmental University
 * Copyright (C) 2014
 */

package ua.edu.odeku.ceem.mapRadar.tools.radar.distributionPowerDensity

import javax.media.opengl.GL

import gov.nasa.worldwind.render.DrawContext

/**
 * Created by Aleo on 14.09.2014.
 */
class ClampToGroundSurface(distributionPowerDensity: DistributionPowerDensity) extends DistributionPowerDensityObject(distributionPowerDensity) {
  override def bind(dc: DrawContext): Unit = {
    val gl = dc.getGL.getGL2
    gl.glVertexPointer(3, GL.GL_FLOAT, 0, this.distributionPowerDensity.renderInfo.geographicVertexBuffer)
    gl.glColorPointer(4, GL.GL_UNSIGNED_BYTE, 0, this.distributionPowerDensity.renderInfo.colorBuffer)
  }

  override protected def drawOutline(dc: DrawContext): Unit = {
    if (!dc.isPickingMode) {
      // Set the outline color.
      val color = this.distributionPowerDensity.attributes.outlineMaterial.getDiffuse
      // Convert the floating point opacity from the range [0, 1] to the unsigned byte range [0, 255].
      val alpha = (255 * this.distributionPowerDensity.attributes.outlineOpacity + 0.5).toInt
      dc.getGL.getGL2.glColor4ub(color.getRed.toByte, color.getGreen.toByte, color.getBlue.toByte, alpha.toByte)
    }
    super.drawOutline(dc)
  }
}
