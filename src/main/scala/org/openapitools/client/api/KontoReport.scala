package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import KontoReport._

case class KontoReport (
  generatedAt: String,
konten: List[KontoItem],
period: String)

object KontoReport {
  import DateTimeCodecs._

  implicit val KontoReportCodecJson: CodecJson[KontoReport] = CodecJson.derive[KontoReport]
  implicit val KontoReportDecoder: EntityDecoder[KontoReport] = jsonOf[KontoReport]
  implicit val KontoReportEncoder: EntityEncoder[KontoReport] = jsonEncoderOf[KontoReport]
}
