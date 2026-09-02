package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SmtpEncryption._

case class SmtpEncryption (
  
object SmtpEncryption {
  import DateTimeCodecs._

  implicit val SmtpEncryptionCodecJson: CodecJson[SmtpEncryption] = CodecJson.derive[SmtpEncryption]
  implicit val SmtpEncryptionDecoder: EntityDecoder[SmtpEncryption] = jsonOf[SmtpEncryption]
  implicit val SmtpEncryptionEncoder: EntityEncoder[SmtpEncryption] = jsonEncoderOf[SmtpEncryption]
}
