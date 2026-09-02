package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import FeatureSettings._

case class FeatureSettings (
  /* Online shop / storefront module (default: enabled). */
  onlineshop: Boolean,
/* Bilanz (balance sheet) report. */
  reportBilanz: Boolean,
/* BWA (betriebswirtschaftliche Auswertung). */
  reportBwa: Boolean,
/* EÜR (Einnahmen-Überschuss-Rechnung). */
  reportEuer: Boolean,
/* Gewerbesteuer report. */
  reportGewerbesteuer: Boolean,
/* GuV (profit & loss) report. */
  reportGuv: Boolean,
/* KSt (Körperschaftsteuer) report. */
  reportKst: Boolean,
/* UStVA (Umsatzsteuervoranmeldung). */
  reportUstva: Boolean)

object FeatureSettings {
  import DateTimeCodecs._

  implicit val FeatureSettingsCodecJson: CodecJson[FeatureSettings] = CodecJson.derive[FeatureSettings]
  implicit val FeatureSettingsDecoder: EntityDecoder[FeatureSettings] = jsonOf[FeatureSettings]
  implicit val FeatureSettingsEncoder: EntityEncoder[FeatureSettings] = jsonEncoderOf[FeatureSettings]
}
