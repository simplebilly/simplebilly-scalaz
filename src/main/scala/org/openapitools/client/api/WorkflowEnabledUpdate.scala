package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import WorkflowEnabledUpdate._

case class WorkflowEnabledUpdate (
  enabled: Boolean)

object WorkflowEnabledUpdate {
  import DateTimeCodecs._

  implicit val WorkflowEnabledUpdateCodecJson: CodecJson[WorkflowEnabledUpdate] = CodecJson.derive[WorkflowEnabledUpdate]
  implicit val WorkflowEnabledUpdateDecoder: EntityDecoder[WorkflowEnabledUpdate] = jsonOf[WorkflowEnabledUpdate]
  implicit val WorkflowEnabledUpdateEncoder: EntityEncoder[WorkflowEnabledUpdate] = jsonEncoderOf[WorkflowEnabledUpdate]
}
