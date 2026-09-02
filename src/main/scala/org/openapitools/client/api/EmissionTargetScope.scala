package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EmissionTargetScope._

case class EmissionTargetScope (
  
object EmissionTargetScope {
  import DateTimeCodecs._

  implicit val EmissionTargetScopeCodecJson: CodecJson[EmissionTargetScope] = CodecJson.derive[EmissionTargetScope]
  implicit val EmissionTargetScopeDecoder: EntityDecoder[EmissionTargetScope] = jsonOf[EmissionTargetScope]
  implicit val EmissionTargetScopeEncoder: EntityEncoder[EmissionTargetScope] = jsonEncoderOf[EmissionTargetScope]
}
