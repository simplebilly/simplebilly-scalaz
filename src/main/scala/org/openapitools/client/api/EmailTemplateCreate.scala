package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EmailTemplateCreate._

case class EmailTemplateCreate (
  /* E-mail body with optional placeholders. */
  body: String,
/* Human-readable template name, e.g. \"Follow-up after quote\". */
  name: String,
/* One of: active | inactive */
  status: EmailTemplateStatus,
/* E-mail subject line with optional placeholders. */
  subject: String,
/* Placeholders used by this template, e.g. `[\"contact.first_name\"]`. */
  variables: Option[AnyType])

object EmailTemplateCreate {
  import DateTimeCodecs._

  implicit val EmailTemplateCreateCodecJson: CodecJson[EmailTemplateCreate] = CodecJson.derive[EmailTemplateCreate]
  implicit val EmailTemplateCreateDecoder: EntityDecoder[EmailTemplateCreate] = jsonOf[EmailTemplateCreate]
  implicit val EmailTemplateCreateEncoder: EntityEncoder[EmailTemplateCreate] = jsonEncoderOf[EmailTemplateCreate]
}
