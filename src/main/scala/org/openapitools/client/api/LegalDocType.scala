package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import LegalDocType._

case class LegalDocType (
  
object LegalDocType {
  import DateTimeCodecs._

  implicit val LegalDocTypeCodecJson: CodecJson[LegalDocType] = CodecJson.derive[LegalDocType]
  implicit val LegalDocTypeDecoder: EntityDecoder[LegalDocType] = jsonOf[LegalDocType]
  implicit val LegalDocTypeEncoder: EntityEncoder[LegalDocType] = jsonEncoderOf[LegalDocType]
}
