package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PrecedingSalesVoucherType._

case class PrecedingSalesVoucherType (
  
object PrecedingSalesVoucherType {
  import DateTimeCodecs._

  implicit val PrecedingSalesVoucherTypeCodecJson: CodecJson[PrecedingSalesVoucherType] = CodecJson.derive[PrecedingSalesVoucherType]
  implicit val PrecedingSalesVoucherTypeDecoder: EntityDecoder[PrecedingSalesVoucherType] = jsonOf[PrecedingSalesVoucherType]
  implicit val PrecedingSalesVoucherTypeEncoder: EntityEncoder[PrecedingSalesVoucherType] = jsonEncoderOf[PrecedingSalesVoucherType]
}
