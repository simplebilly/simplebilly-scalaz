package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import HebesatzLookup._

case class HebesatzLookup (
  bundesland: String,
countryCode: String,
gemeindeName: String,
gemeindeschluessel: String,
hebesatzGewerbesteuer: Double,
hebesatzGrundsteuerB: Option[Double],
jahr: Integer,
landkreis: Option[String],
validFrom: String,
validTo: Option[String])

object HebesatzLookup {
  import DateTimeCodecs._

  implicit val HebesatzLookupCodecJson: CodecJson[HebesatzLookup] = CodecJson.derive[HebesatzLookup]
  implicit val HebesatzLookupDecoder: EntityDecoder[HebesatzLookup] = jsonOf[HebesatzLookup]
  implicit val HebesatzLookupEncoder: EntityEncoder[HebesatzLookup] = jsonEncoderOf[HebesatzLookup]
}
