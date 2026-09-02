package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import InvoiceType._

case class InvoiceType (
  
object InvoiceType {
  import DateTimeCodecs._

  implicit val InvoiceTypeCodecJson: CodecJson[InvoiceType] = CodecJson.derive[InvoiceType]
  implicit val InvoiceTypeDecoder: EntityDecoder[InvoiceType] = jsonOf[InvoiceType]
  implicit val InvoiceTypeEncoder: EntityEncoder[InvoiceType] = jsonEncoderOf[InvoiceType]
}
