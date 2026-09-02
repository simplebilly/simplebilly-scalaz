package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SmtpConfig._

case class SmtpConfig (
  encryption: SmtpEncryption,
fromAddress: String,
fromName: Option[String],
host: String,
password: String,
port: Integer,
timeoutSeconds: Option[Long],
username: String)

object SmtpConfig {
  import DateTimeCodecs._

  implicit val SmtpConfigCodecJson: CodecJson[SmtpConfig] = CodecJson.derive[SmtpConfig]
  implicit val SmtpConfigDecoder: EntityDecoder[SmtpConfig] = jsonOf[SmtpConfig]
  implicit val SmtpConfigEncoder: EntityEncoder[SmtpConfig] = jsonEncoderOf[SmtpConfig]
}
