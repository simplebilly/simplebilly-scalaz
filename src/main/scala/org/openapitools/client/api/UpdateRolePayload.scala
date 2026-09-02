package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import UpdateRolePayload._

case class UpdateRolePayload (
  role: String,
syncPermissions: Option[Boolean])

object UpdateRolePayload {
  import DateTimeCodecs._

  implicit val UpdateRolePayloadCodecJson: CodecJson[UpdateRolePayload] = CodecJson.derive[UpdateRolePayload]
  implicit val UpdateRolePayloadDecoder: EntityDecoder[UpdateRolePayload] = jsonOf[UpdateRolePayload]
  implicit val UpdateRolePayloadEncoder: EntityEncoder[UpdateRolePayload] = jsonEncoderOf[UpdateRolePayload]
}
