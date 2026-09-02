package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DhlCredentials._

case class DhlCredentials (
  /* DHL-API-Key from developer.dhl.com (required for tracking). */
  apiKey: String,
/* Client credentials from the DHL developer app; required for label creation. */
  clientId: Option[String],
clientSecret: Option[String])

object DhlCredentials {
  import DateTimeCodecs._

  implicit val DhlCredentialsCodecJson: CodecJson[DhlCredentials] = CodecJson.derive[DhlCredentials]
  implicit val DhlCredentialsDecoder: EntityDecoder[DhlCredentials] = jsonOf[DhlCredentials]
  implicit val DhlCredentialsEncoder: EntityEncoder[DhlCredentials] = jsonEncoderOf[DhlCredentials]
}
