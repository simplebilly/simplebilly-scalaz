package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EmailTemplate._

case class EmailTemplate (
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

object EmailTemplate {
  import DateTimeCodecs._

  implicit val EmailTemplateCodecJson: CodecJson[EmailTemplate] = CodecJson.derive[EmailTemplate]
  implicit val EmailTemplateDecoder: EntityDecoder[EmailTemplate] = jsonOf[EmailTemplate]
  implicit val EmailTemplateEncoder: EntityEncoder[EmailTemplate] = jsonEncoderOf[EmailTemplate]
}
