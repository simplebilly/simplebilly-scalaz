package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DocumentType._

case class DocumentType (
  
object DocumentType {
  import DateTimeCodecs._

  implicit val DocumentTypeCodecJson: CodecJson[DocumentType] = CodecJson.derive[DocumentType]
  implicit val DocumentTypeDecoder: EntityDecoder[DocumentType] = jsonOf[DocumentType]
  implicit val DocumentTypeEncoder: EntityEncoder[DocumentType] = jsonEncoderOf[DocumentType]
}
