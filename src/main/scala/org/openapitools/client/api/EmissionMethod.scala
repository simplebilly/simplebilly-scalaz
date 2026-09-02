package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EmissionMethod._

case class EmissionMethod (
  
object EmissionMethod {
  import DateTimeCodecs._

  implicit val EmissionMethodCodecJson: CodecJson[EmissionMethod] = CodecJson.derive[EmissionMethod]
  implicit val EmissionMethodDecoder: EntityDecoder[EmissionMethod] = jsonOf[EmissionMethod]
  implicit val EmissionMethodEncoder: EntityEncoder[EmissionMethod] = jsonEncoderOf[EmissionMethod]
}
