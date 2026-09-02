package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import LegalDocumentUpsert._

case class LegalDocumentUpsert (
  content: String,
docType: String,
lang: String,
title: String)

object LegalDocumentUpsert {
  import DateTimeCodecs._

  implicit val LegalDocumentUpsertCodecJson: CodecJson[LegalDocumentUpsert] = CodecJson.derive[LegalDocumentUpsert]
  implicit val LegalDocumentUpsertDecoder: EntityDecoder[LegalDocumentUpsert] = jsonOf[LegalDocumentUpsert]
  implicit val LegalDocumentUpsertEncoder: EntityEncoder[LegalDocumentUpsert] = jsonEncoderOf[LegalDocumentUpsert]
}
