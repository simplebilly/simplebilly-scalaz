package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ApiResponseGdprExport._

case class ApiResponseGdprExport (
  data: Option[ApiResponseGdprExportData],
error: Option[String],
message: Option[String],
success: Boolean)

object ApiResponseGdprExport {
  import DateTimeCodecs._

  implicit val ApiResponseGdprExportCodecJson: CodecJson[ApiResponseGdprExport] = CodecJson.derive[ApiResponseGdprExport]
  implicit val ApiResponseGdprExportDecoder: EntityDecoder[ApiResponseGdprExport] = jsonOf[ApiResponseGdprExport]
  implicit val ApiResponseGdprExportEncoder: EntityEncoder[ApiResponseGdprExport] = jsonEncoderOf[ApiResponseGdprExport]
}
