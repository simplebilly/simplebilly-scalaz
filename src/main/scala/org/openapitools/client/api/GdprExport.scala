package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import GdprExport._

case class GdprExport (
  activityLog: List[GdprActivity],
/* Key identifiers and names only — never a usable credential. */
  apiKeys: List[GdprApiKey],
billing: List[GdprBillingInfo],
exportedAt: OffsetDateTime,
/* Honesty field: this document is a plain data dump, never AI-generated. */
  generatedByAi: Boolean,
notifications: List[GdprNotification],
/* Session records: metadata only, never the token hash. */
  refreshTokens: List[GdprRefreshToken],
tenants: List[GdprTenant],
usageEvents: List[GdprUsageEvent],
user: GdprUser)

object GdprExport {
  import DateTimeCodecs._

  implicit val GdprExportCodecJson: CodecJson[GdprExport] = CodecJson.derive[GdprExport]
  implicit val GdprExportDecoder: EntityDecoder[GdprExport] = jsonOf[GdprExport]
  implicit val GdprExportEncoder: EntityEncoder[GdprExport] = jsonEncoderOf[GdprExport]
}
