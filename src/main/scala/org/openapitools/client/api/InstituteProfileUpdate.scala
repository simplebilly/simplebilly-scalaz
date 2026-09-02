package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import InstituteProfileUpdate._

case class InstituteProfileUpdate (
  instituteType: Option[String],
kapitalmarktorientiert: Option[Boolean])

object InstituteProfileUpdate {
  import DateTimeCodecs._

  implicit val InstituteProfileUpdateCodecJson: CodecJson[InstituteProfileUpdate] = CodecJson.derive[InstituteProfileUpdate]
  implicit val InstituteProfileUpdateDecoder: EntityDecoder[InstituteProfileUpdate] = jsonOf[InstituteProfileUpdate]
  implicit val InstituteProfileUpdateEncoder: EntityEncoder[InstituteProfileUpdate] = jsonEncoderOf[InstituteProfileUpdate]
}
