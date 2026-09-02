package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ExecutionStatus._

case class ExecutionStatus (
  
object ExecutionStatus {
  import DateTimeCodecs._

  implicit val ExecutionStatusCodecJson: CodecJson[ExecutionStatus] = CodecJson.derive[ExecutionStatus]
  implicit val ExecutionStatusDecoder: EntityDecoder[ExecutionStatus] = jsonOf[ExecutionStatus]
  implicit val ExecutionStatusEncoder: EntityEncoder[ExecutionStatus] = jsonEncoderOf[ExecutionStatus]
}
