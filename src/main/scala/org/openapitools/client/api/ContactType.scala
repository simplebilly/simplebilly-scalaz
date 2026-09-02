package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ContactType._

case class ContactType (
  
object ContactType {
  import DateTimeCodecs._

  implicit val ContactTypeCodecJson: CodecJson[ContactType] = CodecJson.derive[ContactType]
  implicit val ContactTypeDecoder: EntityDecoder[ContactType] = jsonOf[ContactType]
  implicit val ContactTypeEncoder: EntityEncoder[ContactType] = jsonEncoderOf[ContactType]
}
