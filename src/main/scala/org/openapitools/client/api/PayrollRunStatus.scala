package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PayrollRunStatus._

case class PayrollRunStatus (
  
object PayrollRunStatus {
  import DateTimeCodecs._

  implicit val PayrollRunStatusCodecJson: CodecJson[PayrollRunStatus] = CodecJson.derive[PayrollRunStatus]
  implicit val PayrollRunStatusDecoder: EntityDecoder[PayrollRunStatus] = jsonOf[PayrollRunStatus]
  implicit val PayrollRunStatusEncoder: EntityEncoder[PayrollRunStatus] = jsonEncoderOf[PayrollRunStatus]
}
