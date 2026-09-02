package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CreateEmissionEntry._

case class CreateEmissionEntry (
  activityValue: String,
categoryId: String,
description: String,
method: String,
scope: String,
unit: String,
year: Integer)

object CreateEmissionEntry {
  import DateTimeCodecs._

  implicit val CreateEmissionEntryCodecJson: CodecJson[CreateEmissionEntry] = CodecJson.derive[CreateEmissionEntry]
  implicit val CreateEmissionEntryDecoder: EntityDecoder[CreateEmissionEntry] = jsonOf[CreateEmissionEntry]
  implicit val CreateEmissionEntryEncoder: EntityEncoder[CreateEmissionEntry] = jsonEncoderOf[CreateEmissionEntry]
}
