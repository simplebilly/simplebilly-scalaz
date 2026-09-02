package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import VoucherType._

case class VoucherType (
  
object VoucherType {
  import DateTimeCodecs._

  implicit val VoucherTypeCodecJson: CodecJson[VoucherType] = CodecJson.derive[VoucherType]
  implicit val VoucherTypeDecoder: EntityDecoder[VoucherType] = jsonOf[VoucherType]
  implicit val VoucherTypeEncoder: EntityEncoder[VoucherType] = jsonEncoderOf[VoucherType]
}
