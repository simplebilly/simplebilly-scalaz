package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PosTableStatus._

case class PosTableStatus (
  
object PosTableStatus {
  import DateTimeCodecs._

  implicit val PosTableStatusCodecJson: CodecJson[PosTableStatus] = CodecJson.derive[PosTableStatus]
  implicit val PosTableStatusDecoder: EntityDecoder[PosTableStatus] = jsonOf[PosTableStatus]
  implicit val PosTableStatusEncoder: EntityEncoder[PosTableStatus] = jsonEncoderOf[PosTableStatus]
}
