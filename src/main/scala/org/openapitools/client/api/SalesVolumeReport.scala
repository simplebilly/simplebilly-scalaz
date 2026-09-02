package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SalesVolumeReport._

case class SalesVolumeReport (
  grandTotal: String,
items: List[SalesVolumeItem],
totalCount: Long)

object SalesVolumeReport {
  import DateTimeCodecs._

  implicit val SalesVolumeReportCodecJson: CodecJson[SalesVolumeReport] = CodecJson.derive[SalesVolumeReport]
  implicit val SalesVolumeReportDecoder: EntityDecoder[SalesVolumeReport] = jsonOf[SalesVolumeReport]
  implicit val SalesVolumeReportEncoder: EntityEncoder[SalesVolumeReport] = jsonEncoderOf[SalesVolumeReport]
}
