package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ShippingCredentials._

case class ShippingCredentials (
  dhl: Option[DhlCredentials],
ups: Option[UpsCredentials])

object ShippingCredentials {
  import DateTimeCodecs._

  implicit val ShippingCredentialsCodecJson: CodecJson[ShippingCredentials] = CodecJson.derive[ShippingCredentials]
  implicit val ShippingCredentialsDecoder: EntityDecoder[ShippingCredentials] = jsonOf[ShippingCredentials]
  implicit val ShippingCredentialsEncoder: EntityEncoder[ShippingCredentials] = jsonEncoderOf[ShippingCredentials]
}
