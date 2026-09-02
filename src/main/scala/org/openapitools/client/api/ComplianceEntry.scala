package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ComplianceEntry._

case class ComplianceEntry (
  description: String,
module: String,
regulations: List[String])

object ComplianceEntry {
  import DateTimeCodecs._

  implicit val ComplianceEntryCodecJson: CodecJson[ComplianceEntry] = CodecJson.derive[ComplianceEntry]
  implicit val ComplianceEntryDecoder: EntityDecoder[ComplianceEntry] = jsonOf[ComplianceEntry]
  implicit val ComplianceEntryEncoder: EntityEncoder[ComplianceEntry] = jsonEncoderOf[ComplianceEntry]
}
