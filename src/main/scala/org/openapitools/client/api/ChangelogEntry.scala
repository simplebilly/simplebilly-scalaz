package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ChangelogEntry._

case class ChangelogEntry (
  date: String,
notes: String,
version: String)

object ChangelogEntry {
  import DateTimeCodecs._

  implicit val ChangelogEntryCodecJson: CodecJson[ChangelogEntry] = CodecJson.derive[ChangelogEntry]
  implicit val ChangelogEntryDecoder: EntityDecoder[ChangelogEntry] = jsonOf[ChangelogEntry]
  implicit val ChangelogEntryEncoder: EntityEncoder[ChangelogEntry] = jsonEncoderOf[ChangelogEntry]
}
