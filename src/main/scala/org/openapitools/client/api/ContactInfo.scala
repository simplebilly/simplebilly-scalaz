package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ContactInfo._

case class ContactInfo (
  hint: String,
hintEn: String,
role: String,
roleEn: String)

object ContactInfo {
  import DateTimeCodecs._

  implicit val ContactInfoCodecJson: CodecJson[ContactInfo] = CodecJson.derive[ContactInfo]
  implicit val ContactInfoDecoder: EntityDecoder[ContactInfo] = jsonOf[ContactInfo]
  implicit val ContactInfoEncoder: EntityEncoder[ContactInfo] = jsonEncoderOf[ContactInfo]
}
