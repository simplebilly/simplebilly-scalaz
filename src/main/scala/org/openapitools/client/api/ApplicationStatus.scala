package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ApplicationStatus._

case class ApplicationStatus (
  
object ApplicationStatus {
  import DateTimeCodecs._

  implicit val ApplicationStatusCodecJson: CodecJson[ApplicationStatus] = CodecJson.derive[ApplicationStatus]
  implicit val ApplicationStatusDecoder: EntityDecoder[ApplicationStatus] = jsonOf[ApplicationStatus]
  implicit val ApplicationStatusEncoder: EntityEncoder[ApplicationStatus] = jsonEncoderOf[ApplicationStatus]
}
