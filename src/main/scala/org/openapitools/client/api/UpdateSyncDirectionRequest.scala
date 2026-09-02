package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import UpdateSyncDirectionRequest._

case class UpdateSyncDirectionRequest (
  directions: Map[String, String])

object UpdateSyncDirectionRequest {
  import DateTimeCodecs._

  implicit val UpdateSyncDirectionRequestCodecJson: CodecJson[UpdateSyncDirectionRequest] = CodecJson.derive[UpdateSyncDirectionRequest]
  implicit val UpdateSyncDirectionRequestDecoder: EntityDecoder[UpdateSyncDirectionRequest] = jsonOf[UpdateSyncDirectionRequest]
  implicit val UpdateSyncDirectionRequestEncoder: EntityEncoder[UpdateSyncDirectionRequest] = jsonEncoderOf[UpdateSyncDirectionRequest]
}
