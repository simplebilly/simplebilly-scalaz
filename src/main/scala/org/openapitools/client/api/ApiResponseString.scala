package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ApiResponseString._

case class ApiResponseString (
  data: Option[String],
error: Option[String],
message: Option[String],
success: Boolean)

object ApiResponseString {
  import DateTimeCodecs._

  implicit val ApiResponseStringCodecJson: CodecJson[ApiResponseString] = CodecJson.derive[ApiResponseString]
  implicit val ApiResponseStringDecoder: EntityDecoder[ApiResponseString] = jsonOf[ApiResponseString]
  implicit val ApiResponseStringEncoder: EntityEncoder[ApiResponseString] = jsonEncoderOf[ApiResponseString]
}
