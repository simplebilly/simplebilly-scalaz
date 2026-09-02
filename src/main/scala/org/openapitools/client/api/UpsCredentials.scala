package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import UpsCredentials._

case class UpsCredentials (
  /* OAuth 2.0 client credentials from developer.ups.com. */
  clientId: String,
clientSecret: String,
/* UPS account number; required for label creation, optional for rates/tracking. */
  shipperNumber: Option[String])

object UpsCredentials {
  import DateTimeCodecs._

  implicit val UpsCredentialsCodecJson: CodecJson[UpsCredentials] = CodecJson.derive[UpsCredentials]
  implicit val UpsCredentialsDecoder: EntityDecoder[UpsCredentials] = jsonOf[UpsCredentials]
  implicit val UpsCredentialsEncoder: EntityEncoder[UpsCredentials] = jsonEncoderOf[UpsCredentials]
}
