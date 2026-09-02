package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import OssReport._

case class OssReport (
  dependencies: List[OssDependency],
totalCount: Integer)

object OssReport {
  import DateTimeCodecs._

  implicit val OssReportCodecJson: CodecJson[OssReport] = CodecJson.derive[OssReport]
  implicit val OssReportDecoder: EntityDecoder[OssReport] = jsonOf[OssReport]
  implicit val OssReportEncoder: EntityEncoder[OssReport] = jsonEncoderOf[OssReport]
}
