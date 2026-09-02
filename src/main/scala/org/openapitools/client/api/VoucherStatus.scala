package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import VoucherStatus._

case class VoucherStatus (
  
object VoucherStatus {
  import DateTimeCodecs._

  implicit val VoucherStatusCodecJson: CodecJson[VoucherStatus] = CodecJson.derive[VoucherStatus]
  implicit val VoucherStatusDecoder: EntityDecoder[VoucherStatus] = jsonOf[VoucherStatus]
  implicit val VoucherStatusEncoder: EntityEncoder[VoucherStatus] = jsonEncoderOf[VoucherStatus]
}
