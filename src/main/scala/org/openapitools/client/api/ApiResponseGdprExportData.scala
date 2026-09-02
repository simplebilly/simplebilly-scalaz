package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import ApiResponseGdprExportData._

case class ApiResponseGdprExportData (
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

object ApiResponseGdprExportData {
  import DateTimeCodecs._

  implicit val ApiResponseGdprExportDataCodecJson: CodecJson[ApiResponseGdprExportData] = CodecJson.derive[ApiResponseGdprExportData]
  implicit val ApiResponseGdprExportDataDecoder: EntityDecoder[ApiResponseGdprExportData] = jsonOf[ApiResponseGdprExportData]
  implicit val ApiResponseGdprExportDataEncoder: EntityEncoder[ApiResponseGdprExportData] = jsonEncoderOf[ApiResponseGdprExportData]
}
