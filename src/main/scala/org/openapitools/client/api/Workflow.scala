package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Workflow._

case class Workflow (
  actions: Option[AnyType],
enabled: Option[Boolean],
name: String,
/* Event that triggers the workflow, e.g. `order.paid`, `order.shipped`. */
  triggerEvent: String)

object Workflow {
  import DateTimeCodecs._

  implicit val WorkflowCodecJson: CodecJson[Workflow] = CodecJson.derive[Workflow]
  implicit val WorkflowDecoder: EntityDecoder[Workflow] = jsonOf[Workflow]
  implicit val WorkflowEncoder: EntityEncoder[Workflow] = jsonEncoderOf[Workflow]
}
