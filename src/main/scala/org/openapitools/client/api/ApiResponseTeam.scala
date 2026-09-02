package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ApiResponseTeam._

case class ApiResponseTeam (
  data: Option[ApiResponseTeamData],
error: Option[String],
message: Option[String],
success: Boolean)

object ApiResponseTeam {
  import DateTimeCodecs._

  implicit val ApiResponseTeamCodecJson: CodecJson[ApiResponseTeam] = CodecJson.derive[ApiResponseTeam]
  implicit val ApiResponseTeamDecoder: EntityDecoder[ApiResponseTeam] = jsonOf[ApiResponseTeam]
  implicit val ApiResponseTeamEncoder: EntityEncoder[ApiResponseTeam] = jsonEncoderOf[ApiResponseTeam]
}
