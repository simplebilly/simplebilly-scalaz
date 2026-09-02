package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ServiceJobStatus._

case class ServiceJobStatus (
  
object ServiceJobStatus {
  import DateTimeCodecs._

  implicit val ServiceJobStatusCodecJson: CodecJson[ServiceJobStatus] = CodecJson.derive[ServiceJobStatus]
  implicit val ServiceJobStatusDecoder: EntityDecoder[ServiceJobStatus] = jsonOf[ServiceJobStatus]
  implicit val ServiceJobStatusEncoder: EntityEncoder[ServiceJobStatus] = jsonEncoderOf[ServiceJobStatus]
}
