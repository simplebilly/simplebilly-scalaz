package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import RecurringTemplateType._

case class RecurringTemplateType (
  
object RecurringTemplateType {
  import DateTimeCodecs._

  implicit val RecurringTemplateTypeCodecJson: CodecJson[RecurringTemplateType] = CodecJson.derive[RecurringTemplateType]
  implicit val RecurringTemplateTypeDecoder: EntityDecoder[RecurringTemplateType] = jsonOf[RecurringTemplateType]
  implicit val RecurringTemplateTypeEncoder: EntityEncoder[RecurringTemplateType] = jsonEncoderOf[RecurringTemplateType]
}
