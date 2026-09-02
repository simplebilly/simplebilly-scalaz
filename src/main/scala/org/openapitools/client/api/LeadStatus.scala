package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import LeadStatus._

case class LeadStatus (
  
object LeadStatus {
  import DateTimeCodecs._

  implicit val LeadStatusCodecJson: CodecJson[LeadStatus] = CodecJson.derive[LeadStatus]
  implicit val LeadStatusDecoder: EntityDecoder[LeadStatus] = jsonOf[LeadStatus]
  implicit val LeadStatusEncoder: EntityEncoder[LeadStatus] = jsonEncoderOf[LeadStatus]
}
