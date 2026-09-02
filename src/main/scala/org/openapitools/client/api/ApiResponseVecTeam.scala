package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ApiResponseVecTeam._

case class ApiResponseVecTeam (
  data: Option[List[ApiResponseTeamData]],
error: Option[String],
message: Option[String],
success: Boolean)

object ApiResponseVecTeam {
  import DateTimeCodecs._

  implicit val ApiResponseVecTeamCodecJson: CodecJson[ApiResponseVecTeam] = CodecJson.derive[ApiResponseVecTeam]
  implicit val ApiResponseVecTeamDecoder: EntityDecoder[ApiResponseVecTeam] = jsonOf[ApiResponseVecTeam]
  implicit val ApiResponseVecTeamEncoder: EntityEncoder[ApiResponseVecTeam] = jsonEncoderOf[ApiResponseVecTeam]
}
