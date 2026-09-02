package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import UpdatePermissionsPayload._

case class UpdatePermissionsPayload (
  permissions: List[String])

object UpdatePermissionsPayload {
  import DateTimeCodecs._

  implicit val UpdatePermissionsPayloadCodecJson: CodecJson[UpdatePermissionsPayload] = CodecJson.derive[UpdatePermissionsPayload]
  implicit val UpdatePermissionsPayloadDecoder: EntityDecoder[UpdatePermissionsPayload] = jsonOf[UpdatePermissionsPayload]
  implicit val UpdatePermissionsPayloadEncoder: EntityEncoder[UpdatePermissionsPayload] = jsonEncoderOf[UpdatePermissionsPayload]
}
