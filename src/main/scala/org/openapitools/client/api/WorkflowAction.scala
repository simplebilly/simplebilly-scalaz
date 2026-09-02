package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import WorkflowAction._

case class WorkflowAction (
  actionType: String,
body: Option[String],
subject: Option[String])

object WorkflowAction {
  import DateTimeCodecs._

  implicit val WorkflowActionCodecJson: CodecJson[WorkflowAction] = CodecJson.derive[WorkflowAction]
  implicit val WorkflowActionDecoder: EntityDecoder[WorkflowAction] = jsonOf[WorkflowAction]
  implicit val WorkflowActionEncoder: EntityEncoder[WorkflowAction] = jsonEncoderOf[WorkflowAction]
}
