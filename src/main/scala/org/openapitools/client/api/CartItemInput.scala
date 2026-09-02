package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import CartItemInput._

case class CartItemInput (
  productId: UUID,
quantity: Integer)

object CartItemInput {
  import DateTimeCodecs._

  implicit val CartItemInputCodecJson: CodecJson[CartItemInput] = CodecJson.derive[CartItemInput]
  implicit val CartItemInputDecoder: EntityDecoder[CartItemInput] = jsonOf[CartItemInput]
  implicit val CartItemInputEncoder: EntityEncoder[CartItemInput] = jsonEncoderOf[CartItemInput]
}
