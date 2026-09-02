package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EmailTemplateStatus._

case class EmailTemplateStatus (
  
object EmailTemplateStatus {
  import DateTimeCodecs._

  implicit val EmailTemplateStatusCodecJson: CodecJson[EmailTemplateStatus] = CodecJson.derive[EmailTemplateStatus]
  implicit val EmailTemplateStatusDecoder: EntityDecoder[EmailTemplateStatus] = jsonOf[EmailTemplateStatus]
  implicit val EmailTemplateStatusEncoder: EntityEncoder[EmailTemplateStatus] = jsonEncoderOf[EmailTemplateStatus]
}
