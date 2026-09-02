package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import GenerateVariantsRequest._

case class GenerateVariantsRequest (
  /* Option name → list of values, e.g. `{\"Color\": [\"Red\", \"Blue\"], \"Size\": [\"S\", \"M\"]}`. The cartesian product of these lists is generated. */
  options: Option[Map[String, List[String]]],
/* Optional per-variant price delta applied to every generated variant. */
  priceDelta: Option[String],
productId: UUID,
/* Optional prefix for the generated SKUs (suffix is the option values joined by `-`). Falls back to the parent product's SKU. */
  skuPrefix: Option[String])

object GenerateVariantsRequest {
  import DateTimeCodecs._

  implicit val GenerateVariantsRequestCodecJson: CodecJson[GenerateVariantsRequest] = CodecJson.derive[GenerateVariantsRequest]
  implicit val GenerateVariantsRequestDecoder: EntityDecoder[GenerateVariantsRequest] = jsonOf[GenerateVariantsRequest]
  implicit val GenerateVariantsRequestEncoder: EntityEncoder[GenerateVariantsRequest] = jsonEncoderOf[GenerateVariantsRequest]
}
