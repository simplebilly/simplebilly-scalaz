package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import UpdateAutomation._

case class UpdateAutomation (
  config: Option[AnyType],
enabled: Option[Boolean])

object UpdateAutomation {
  import DateTimeCodecs._

  implicit val UpdateAutomationCodecJson: CodecJson[UpdateAutomation] = CodecJson.derive[UpdateAutomation]
  implicit val UpdateAutomationDecoder: EntityDecoder[UpdateAutomation] = jsonOf[UpdateAutomation]
  implicit val UpdateAutomationEncoder: EntityEncoder[UpdateAutomation] = jsonEncoderOf[UpdateAutomation]
}
