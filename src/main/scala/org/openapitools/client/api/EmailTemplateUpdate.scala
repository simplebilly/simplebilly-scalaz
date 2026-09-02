package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EmailTemplateUpdate._

case class EmailTemplateUpdate (
  /* E-mail body with optional placeholders. */
  body: Option[String],
/* Human-readable template name, e.g. \"Follow-up after quote\". */
  name: Option[String],
/* One of: active | inactive */
  status: Option[EmailTemplateStatus],
/* E-mail subject line with optional placeholders. */
  subject: Option[String],
/* Placeholders used by this template, e.g. `[\"contact.first_name\"]`. */
  variables: Option[AnyType])

object EmailTemplateUpdate {
  import DateTimeCodecs._

  implicit val EmailTemplateUpdateCodecJson: CodecJson[EmailTemplateUpdate] = CodecJson.derive[EmailTemplateUpdate]
  implicit val EmailTemplateUpdateDecoder: EntityDecoder[EmailTemplateUpdate] = jsonOf[EmailTemplateUpdate]
  implicit val EmailTemplateUpdateEncoder: EntityEncoder[EmailTemplateUpdate] = jsonEncoderOf[EmailTemplateUpdate]
}
